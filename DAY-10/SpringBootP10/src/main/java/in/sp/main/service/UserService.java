package in.sp.main.service;

import org.springframework.stereotype.Service;

import in.sp.main.entity.User;
@Service
public interface UserService 
{
	User createUser(User user);
}
