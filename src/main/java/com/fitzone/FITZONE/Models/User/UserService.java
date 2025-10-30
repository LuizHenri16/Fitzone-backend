package com.fitzone.FITZONE.Models.User;

import com.fitzone.FITZONE.DTO.UserDTO;
import com.fitzone.FITZONE.Repository.UserRepository;
import com.fitzone.FITZONE.Types.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserDTO userDTO) {
        User newUser = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getAccess());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userRepository.save(newUser);
    }

    public User editCustomer(Long id, UserDTO userDTO) {

        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setUsername(userDTO.getUsername());
        updateUser.setAccess(userDTO.getAccess());
        updateUser.setPassword(passwordEncoder.encode((userDTO.getPassword())));

        return userRepository.save(updateUser);
    }

    public List<UserDTO> findUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setAccess(user.getAccess());

            usersDTO.add(userDTO);
        }
        return usersDTO;
    }

    public UserDTO findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.get().getId());
        userDTO.setUsername(user.get().getUsername());
        userDTO.setAccess(user.get().getAccess());

        return userDTO;
    }

    public boolean deleteByID(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
