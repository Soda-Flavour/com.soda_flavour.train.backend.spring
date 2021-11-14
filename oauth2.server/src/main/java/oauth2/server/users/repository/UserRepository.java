package oauth2.server.users.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import oauth2.server.core.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    
}
