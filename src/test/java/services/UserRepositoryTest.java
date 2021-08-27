package services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import twitter.App;
import twitter.users.User;
import twitter.users.UserJpaRepository;
import twitter.users.UserRepository;
import twitter.users.UsersJpaAdapter;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class UserRepositoryTest {

    private UserRepository repository;

    @Autowired
    private UserJpaRepository rep;

    @Before
    public void init(){
        repository = new UsersJpaAdapter(rep);
    }
    @Test
    public  void getUser(){
       User jpa = repository.getUser("blabla");
        Assert.assertNotNull(jpa);
    }
}
