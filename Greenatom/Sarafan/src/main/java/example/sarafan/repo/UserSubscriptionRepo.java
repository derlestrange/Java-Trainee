package example.sarafan.repo;

import example.sarafan.domain.User;
import example.sarafan.domain.UserSubscription;
import example.sarafan.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);

    List<UserSubscription> findByChannel(User channel);

    UserSubscription findByChannelAndSubscriber(User channel, User subscriber);
}
