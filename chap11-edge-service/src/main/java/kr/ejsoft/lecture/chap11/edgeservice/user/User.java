package kr.ejsoft.lecture.chap11.edgeservice.user;

import java.util.List;

public record User(
        String username,
        String firstName,
        String lastName,
        List<String> roles
) {
}
