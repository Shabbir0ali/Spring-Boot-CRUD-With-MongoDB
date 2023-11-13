package com.shabbir.api.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shabbir.api.user.dto.UserDTO;
import com.shabbir.api.user.model.User;
import com.shabbir.api.user.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDTO user) {
		return ResponseEntity.ok(this.service.saveUser(user));
	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(this.service.getAllUser());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getByUserId(@PathVariable String id){
		return ResponseEntity.ok(this.service.findByUserId(id)) ;
	}
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id , @RequestBody User user){
		return ResponseEntity.ok(this.service.updateUser(id,user));
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteUserById(@PathVariable String id){
		this.service.deleteUserById(id);
		HashMap<String, Boolean> msp = new HashMap<String,Boolean>();
	msp.put("Deleted", Boolean.TRUE);
	return ResponseEntity.ok(msp);
	}
}