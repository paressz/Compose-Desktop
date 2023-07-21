package data.model

data class Book(
    val bookName : String,
    val publisher : String,
    val id : Int = 0
)

object BookSample {
    val sample = listOf(
        Book("BOOK 1", "PUB 1"),
        Book("BOOK 2", "PUB 2"),
        Book("BOOK 3", "PUB 3"),
        Book("BOOK 4", "PUB 4"),
        Book("BOOK 5", "PUB 6"),
        Book("BOOK 7", "PUB 7"),
        Book("BOOK 8", "PUB 8"),

    )
}
