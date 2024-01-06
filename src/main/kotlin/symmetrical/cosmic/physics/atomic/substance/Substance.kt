package symmetrical.cosmic.physics.atomic.substance

/*
https://en.wikipedia.org/wiki/Chemical_substance
 */
interface Substance {
    fun addDerived(substance: Substance) : Substance
    fun run () : Unit
}