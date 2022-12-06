package br.com.likepay.picpayLike.resource;

import br.com.likepay.picpayLike.dto.UserDTO;
import br.com.likepay.picpayLike.model.User;
import br.com.likepay.picpayLike.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource extends ResourceBase<UserDTO> {

    @Autowired
    private IUserService userService;

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> search(@PathVariable String login){
        UserDTO userDTO = userService.search(login);
        return responseSucessWithItem(userDTO);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<UserDTO>> list(@RequestParam String login){
        List<UserDTO> users = userService.list(login);
        return responseListItems(users);
    }

    @GetMapping("/{login}/saldo")
    public ResponseEntity<UserDTO> consultBalance(@PathVariable String login){
        UserDTO userDTO = userService.search(login);
        return responseSucessWithItem(userDTO);
    }
}
