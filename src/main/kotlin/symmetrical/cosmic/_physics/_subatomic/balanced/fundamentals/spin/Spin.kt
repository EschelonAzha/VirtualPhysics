package symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.balanced.values.Field
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

open class Spin(
    private val fermion: IFermion = Fermion(Spin::class),
) : Particle(fermion),
    IFermion by fermion,
    Emitter
{
    constructor() : this(
        Fermion(Spin::class),
    )

    object Static {
        const val PLUS :Int      = +1
        const val MINUS:Int      = -1
    }

    val field:Field = Field(Spin.Static.PLUS)


    private fun check(photon: Photon) : Unit {
        val classId = fermion.getClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return photon.propagate()
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()  // spin has no fields, we only need to know the
                             // type of spin
    }
    override fun getClassId() : String {
        return fermion.getClassId()
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