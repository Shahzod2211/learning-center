package com.example.learningcenter.user;

import com.example.learningcenter.user.dto.ForgotPasswordDTO;
import com.example.learningcenter.user.dto.UserSignUpDTO;
import com.example.learningcenter.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByPhoneNumber(username).get();
    }

    public void create(UserSignUpDTO userSignUpDTO) {
        User user = modelMapper.map(userSignUpDTO, User.class);
        userRepository.save(user);
    }

    public void updatePassword(ForgotPasswordDTO forgotPasswordDTO) {
        User user = userRepository.findUserByPhoneNumber(forgotPasswordDTO.getPhoneNumber()).get();
        user.setPassword(forgotPasswordDTO.getPassword());
        userRepository.save(user);
    }
}
