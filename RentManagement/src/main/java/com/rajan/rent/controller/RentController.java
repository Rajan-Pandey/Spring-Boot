package com.rajan.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.rent.models.RentReceipt;
import com.rajan.rent.repos.RepoRepository;


@RestController
public class RentController {
	
@Autowired
RepoRepository repo;

@PostMapping("/api/RentReceipts")
public ResponseEntity<RentReceipt> addRentRecepit(@RequestBody RentReceipt rentReceipt)
{
	repo.save(rentReceipt);
	return ResponseEntity.status(HttpStatus.CREATED).body(rentReceipt);
}

@GetMapping("/api/RentReceipts")
@ResponseStatus(value = HttpStatus.OK)
public List<RentReceipt> getAll()
{
	return repo.findAll();
}

@GetMapping("/api/RentReceipts/{id}")
public RentReceipt getOneRent(@PathVariable("id") int id)
{
	return repo.findById(id).get();
}

@PatchMapping("/api/RentReceipts/{id}")
public ResponseEntity<RentReceipt> udpdateRent(@PathVariable("id") int id, @RequestBody RentReceipt receiptDetails)
{
	try
		{
		RentReceipt receipt = repo.findById(id).get();
			if(receipt.isPaid() != Boolean.TRUE)
				{
					receipt.setPaid(receiptDetails.isPaid());
					receipt.setPaidOn(receiptDetails.getPaidOn());
					repo.save(receipt);
				return new ResponseEntity(receipt ,HttpStatus.OK);
				}
		}
	catch(Exception e)
		{
		}
 return new ResponseEntity(HttpStatus.BAD_REQUEST);
}

@DeleteMapping("/api/RentReceipts/{id}")
public void deleteRent(@PathVariable("id") int id)
{
		repo.deleteById(id);
	}
}
