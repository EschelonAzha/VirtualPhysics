package symmetrical.cosmic._physics.atomic.bonds.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter
/*
https://en.wikipedia.org/wiki/Alloy
 */

open class Alloy(
    val mixtures: Substance? = null,
    private val matter: IMatter = Matter(Alloy::class, Alloy::class),
) :
    IMatter by matter
{
    constructor() : this(
        null,
        Matter(Alloy::class, Alloy::class),
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
        return matter.getClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}