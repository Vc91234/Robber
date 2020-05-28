package com.springboot.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Robber;
import com.springboot.model1.CaptainRepo;

@RestController
@RequestMapping("/api")
public class ProfessorTheController
{
	@Autowired
	CaptainRepo repo;
	
	@DeleteMapping("/robber/{id}")
	public String deleteRobber(@PathVariable int id)
	{
		Robber a = repo.getOne(id);
		repo.delete(a);
		return "deleted";
	}
	
	@PostMapping("/robber")
	public Robber addRobber(@RequestBody Robber robber)
	{
		repo.save(robber);
		return robber;
	}
	
	@GetMapping(path="/robbers")
	public List<Robber> getRobbers()
	{
		return repo.findAll();
	}
	
	@PutMapping("/robber/{id}")
	public Robber saveOrUpdateRobber(@RequestBody Robber robber,@PathVariable int id)
	{
		repo.save(robber);
		return robber;
	}
	
	@RequestMapping("/robber/{id}")
	public Optional<Robber> getRobber(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
}
