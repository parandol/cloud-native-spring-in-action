package kr.ejsoft.lecture.chap16.quotefunction.domain;

public record Quote(
        String content,
        String author,
        Genre genre
) {
}
