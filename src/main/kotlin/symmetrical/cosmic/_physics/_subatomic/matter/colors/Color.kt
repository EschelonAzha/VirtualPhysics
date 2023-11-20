package symmetrical.cosmic._physics._subatomic.matter.colors

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

open class Color(private val entanglement: IQuantumEntanglement = QuantumEntanglement()): ChromoCharge(), IQuantumEntanglement by entanglement {

    constructor() : this(QuantumEntanglement()) {
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Color::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    override fun i() : Color {
        super.i()
        return this
    }
}