package uz.otamurod.sharedelementtransition.model

data class Mountain(
    val title: String,
    val description: String,
    val image: String,
)

val mountains = listOf(
    Mountain(
        title = "Gray and Brown Mountain",
        description = "In the heart of the nature's majestic canvas, the \"Gray and Brown Mountain\"...",
        image = "https://images.pexels.com/photos/417173/pexels-photo-417173.jpeg"
    ),
    Mountain(
        title = "Mountains covered in Snow",
        description = "A pristine world unfolds beneath the title \"Mountains covered in Snow\"...",
        image = "https://media.istockphoto.com/id/584574568/photo/mountains-landscape.jpg?s=612x612&w=0&k=20&c=78E20f5Le6MRadvEv8q3pzyqqFFIjnhIRzLcsv_X2_M="
    ),
    Mountain(
        title = "Black and Teal Mountain",
        description = "Amidst the wild expense, the \"Black and Teal Mountain\" emerges as a ...",
        image = "https://images.pexels.com/photos/540518/pexels-photo-540518.jpeg"
    )
)
