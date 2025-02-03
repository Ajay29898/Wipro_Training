package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
	
}
