package symmetrical.cosmic._physics.atomic.substance

interface Substance {
    fun addDerived(substance: Substance) : Substance
    fun run () : Unit
}