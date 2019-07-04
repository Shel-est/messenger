package com.example.messenger.repository;

import com.example.messenger.domain.User;
import com.example.messenger.domain.UserSubscription;
import com.example.messenger.domain.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
}
