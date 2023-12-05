package symmetrical.cosmic._physics.atomic.bonds.alloys

import symmetrical.cosmic._physics.atomic.substance.Substance
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter


open class Alloy(
    val mixtures: Substance? = null,
    private val antiMatter: IAntiMatter = AntiMatter(Alloy::class, Alloy::class),
) :
    IAntiMatter by antiMatter
{
    constructor() : this(
        null,
        AntiMatter(Alloy::class, Alloy::class),
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
        return antiMatter.getClassId()
    }

    fun getSubstance(pos:Int) : Substance {
        return this.mixture[pos]
    }

    open fun run() : Unit {
        println("I'm running");
    }
}