package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entity.User;
import in.sp.main.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserRepository userRepository;
	@Override
	public User createUser(User user) 
	{
		return userRepository.save(user);
	}
	
}
