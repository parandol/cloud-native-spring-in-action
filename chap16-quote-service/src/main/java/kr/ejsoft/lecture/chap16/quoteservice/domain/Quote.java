package kr.ejsoft.lecture.chap16.quoteservice.domain;

public record Quote(
        String content,
        String author,
        Genre genre
) {
}
