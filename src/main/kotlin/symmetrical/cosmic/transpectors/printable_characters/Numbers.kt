package symmetrical.cosmic.transpectors.printable_characters

class Numbers : Characters {

    companion object {
        const val NUMBERS: String = "01234567890";
    }
    constructor() : super() {
    }

    fun i() : Numbers {
        super.i(NUMBERS);
        return this;
    }
}