package com.chinthana.learn.springboot.restfull.restfullwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinthana.learn.springboot.restfull.restfullwebservices.data.Name;
import com.chinthana.learn.springboot.restfull.restfullwebservices.data.UserV1;
import com.chinthana.learn.springboot.restfull.restfullwebservices.data.UserV2;

@RestController
public class UserApiVersioningController {
	
	/**
	 * URI API versioning
	 * @return
	 */
	
	@GetMapping("/v1/user")
	public UserV1 getUserV1() {
		return new UserV1("Chinthana Bandara");
	}
	
	@GetMapping("/v2/user")
	public UserV2 getUserV2() {
		return new UserV2(new Name("Chinthana", "Bandara"));
	}
	
	/**
	 * Versioning doing by Query Params.
	 * Request parameter API versioning
	 * @return
	 */
	
	@GetMapping(value="/user/param", params="version=1")
	public UserV1 getUserV1WithParam() {
		return new UserV1("Chinthana Bandara");
	}
	
	@GetMapping(value="/user/param", params="version=2")
	public UserV2 getUserV2WithParam() {
		return new UserV2(new Name("Chinthana", "Bandara"));
	}
	
	/**
	 * Versioning doing by Header Params.
	 * Header versioning
	 * 
	 * @return
	 */
	@GetMapping(value="/user/header", headers="X-API-VERSION=1")
	public UserV1 getUserV1WithHeader() {
		return new UserV1("Chinthana Bandara");
	}
	
	@GetMapping(value="/user/header", headers="X-API-VERSION=2")
	public UserV2 getUserV2WithHeader() {
		return new UserV2(new Name("Chinthana", "Bandara"));
	}
	
	/**
	 * Versioning doing by Produces. Mime type versioning
	 * Accept header versioning
	 * 
	 * @return
	 */
	@GetMapping(value="/user/produces", produces="application/user.api.v1+json")
	public UserV1 getUserV1WithProduces() {
		return new UserV1("Chinthana Bandara");
	}
	
	@GetMapping(value="/user/produces", produces="application/user.api.v2+json")
	public UserV2 getUserV2Produces() {
		return new UserV2(new Name("Chinthana", "Bandara"));
	}
}
