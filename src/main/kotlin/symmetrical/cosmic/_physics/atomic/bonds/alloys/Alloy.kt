package symmetrical.cosmic._physics.atomic.bonds.alloys

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.substance.Substance
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement


open class Alloy(
    vararg mixtures: Substance,
    private val fermion: IQuantumEntanglement = QuantumEntanglement(),
) :
    IQuantumEntanglement by fermion
{

    var derived = ArrayList<Substance>()
    var mixture = ArrayList<Substance>()

    init {
        for (substance in mixtures) {
            substance.addDerived(substance)
            mixture.add(substance)
        }
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(Alloy::class)
    }
    open fun getClassId() : String {
        return getLocalClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}