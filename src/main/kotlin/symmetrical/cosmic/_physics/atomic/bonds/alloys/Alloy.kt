package symmetrical.cosmic._physics.atomic.bonds.alloys

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.substance.Substance
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


open class Alloy(
    val mixtures: Substance? = null,
    private val fermion: IFermion = Fermion(Alloy::class),
) :
    IFermion by fermion
{
    constructor() : this(
        null,
        Fermion(Alloy::class),
    )
    var derived = ArrayList<Substance>()
    var mixture = ArrayList<Substance>()

    init {
//        for (substance in mixtures) {
//            substance.addDerived(substance)
//            mixture.add(substance)
//        }
    }

    override fun getClassId() : String {
        return fermion.getClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}