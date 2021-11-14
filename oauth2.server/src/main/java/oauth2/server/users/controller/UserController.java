package oauth2.server.users.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oauth2.server.core.User;
import oauth2.server.users.controller.request.AddressCreateRequest;
import oauth2.server.users.repository.UserRepository;
import oauth2.server.users.service.UserService;

@RequestMapping("/usrs")
@RepositoryRestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<AddressReadResponse> read(@PathVariable("userId") Long userId) {
        log.info("이곳을 타고 끝납니다...");
        User user = userRepository.findById(userId).get();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity<>(new AddressReadResponse(user.getId(), user.getName()), header, HttpStatus.OK);
    }



    ///////////////////////////////////////////////////////////////
    // CREATE
    ///////////////////////////////////////////////////////////////
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AddressCreateRequest request) {


        User address = User.builder().name(request.getName()).phoneNumber(request.getPhoneNumber()).build();
        userService.create(address); 

    
        return ResponseEntity.ok().body(null);
    }





    @Data
    @AllArgsConstructor
    public static class AddressReadResponse {
        private Long id;
        private String name;
    }
}
