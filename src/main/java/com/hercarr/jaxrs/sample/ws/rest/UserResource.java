package com.hercarr.jaxrs.sample.ws.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.hercarr.jaxrs.sample.model.User;
import com.hercarr.jaxrs.sample.model.UserService;

@Path("/users")
public class UserResource {
	
	private Gson gson;
	private UserService userService;
	
	public UserResource() {
		gson = new Gson();
		userService = new UserService();
	}
	
	/*
	@GET
	@Path("/{name}")
	public String helloWorld(@PathParam("name") String name) {
		return "Hi " + name + ", Hello World!!!";
	}
	*/
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public String findAllUsers() {
		List<User> users = userService.getUsers();
		return gson.toJson(users);
	}
	
	@POST
	@Path("")
	@Produces("application/json")
	public String addUser(String json) {
		User user = gson.fromJson(json, User.class);
		return gson.toJson(userService.addUser(user));
	}
	
	@PUT
	@Path("")
	@Produces("application/json")
	public String updateUser(String json) {
		User user = gson.fromJson(json, User.class);
		return gson.toJson(userService.updateUser(user));
	}
	
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public String deleteUser(@PathParam("id") Integer id) {
		return gson.toJson(userService.deleteUser(id));
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public String findUser(@PathParam("id") Integer id) {
		User user = userService.findUserById(id);
		return gson.toJson(user);
	}

}