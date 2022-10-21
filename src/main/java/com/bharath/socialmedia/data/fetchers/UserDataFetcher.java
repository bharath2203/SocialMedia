package com.bharath.socialmedia.data.fetchers;

import com.bharath.socialmedia.generated.models.types.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import java.util.List;

@DgsComponent
public class UserDataFetcher {

    @DgsQuery
    public List<User> users() {
        return List.of(
                User.newBuilder().userId("id1").userName("Name1").build(),
                User.newBuilder().userId("id2").userName("Name2").build()
        );
    }

}
