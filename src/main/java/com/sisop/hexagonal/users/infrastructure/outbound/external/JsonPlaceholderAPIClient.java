package com.sisop.hexagonal.users.infrastructure.outbound.external;

import com.sisop.hexagonal.users.domain.model.UserCommand;
import com.sisop.hexagonal.users.domain.model.UserQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "users", url = "https://jsonplaceholder.typicode.com/users")
public interface JsonPlaceholderAPIClient {
    @PostMapping
    UserQuery create(@RequestBody UserCommand request);

    @GetMapping("/{id}")
    UserQuery findPostById(@PathVariable Integer id);

    @GetMapping
    List<UserQuery> getAllPosts();

    @GetMapping
    List<UserQuery> searchByParam(@RequestParam Map<String, String> params);
}
