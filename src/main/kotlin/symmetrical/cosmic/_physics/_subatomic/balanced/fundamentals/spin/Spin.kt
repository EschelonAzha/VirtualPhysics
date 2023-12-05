package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

open class Spin(
    private val antiMatter: IAntiMatter = AntiMatter(Spin::class, Spin::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Spin::class, Spin::class),
    )

    object Static {
        const val PLUS :Int      = +1
        const val MINUS:Int      = -1
    }

    val field:Field = Field(Spin.Static.PLUS)



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()  // spin has no fields, we only need to know the
                             // type of spin
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }

    fun isPlus() : Boolean {
        return field.toInt() > 0
    }
    fun isMinus() : Boolean {
        return field.toInt() < 0
    }

    fun setSpin(value:Int) : Spin {
        field.setValue(value)
        return this
    }

    fun spinPlus() : Spin {
        field.setValue(Spin.Static.PLUS)
        return this
    }
    fun spinMinus() : Spin {
        field.setValue(Static.MINUS)
        return this
    }
}