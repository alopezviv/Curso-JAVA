package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springBootInitialDemo.dto.UserResponseDto;
import springBootInitialDemo.service.IUserService;

@RestController
@RequestMapping("/v1")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }
    //nivell 1 fase 2
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
    @GetMapping("/{name}")
    public String helloName(@PathVariable(name="name") String name) {
    	String result = "Hello, " + name;
    	
    	
    	return result;
    }

    //@PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }


}
