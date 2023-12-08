package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._dimensions.Dimensions
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.luminescent.*


open class Quark(
    private val matter: IMatter = Matter(Quark::class, AntiQuark::class, true),
) : Particle(),
    IMatter by matter,
    Emitter
{
    constructor() : this(
        Matter(Quark::class, AntiQuark::class, true),
    ) {
        this.gluon         = Red_AntiRed()
    }
    init {

    }

    lateinit var gluon                  : Gluon

    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        this.gluon                          = Red_AntiRed()  // this is need for JS Bug
        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentals = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return matter.getClassId()+fundamentals.emit().radiate()
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    open fun i() : Quark {
        return this
    }

    class Args(val value:Any?) : ZBoson()
    fun z(boson: Args) : Args {
        red()

        // need a way to transmit errors back
        // should I use a return code or something more
        // elaborate like electrons, neutrinos, etc
        // Args should be Z or W Bosons


        gluon.setValue(boson.value)
        setValue(boson.value)

        return boson
    }

    fun red() : Any? {
        if (gluon.color.isRed())
            return gluon.color._value

        if (gluon.color.isGreen())
            gluon = Green_AntiBlue().red(gluon)
        else gluon = Blue_AntiGreen().red(gluon)

        return gluon.color._value
    }

    fun blue() : String {
        if (gluon.color.isBlue())
            return gluon.color._value as String

        if (gluon.color.isGreen())
            gluon = Green_AntiRed().blue(gluon)
        else gluon = Red_AntiGreen().blue(gluon)

        return gluon.color._value as String
    }

    fun green() : String {
        if (gluon.color.isGreen())
            return gluon.color._value as String

        if (gluon.color.isBlue())
            gluon = Blue_AntiRed().green(gluon)
        else gluon = Red_AntiBlue().green(gluon)

        return gluon.color._value as String
    }
    fun currentColor() : Any? {
        return gluon.color._value
    }

    open fun dissipate() : Unit {

    }

    fun setGreen(green: Green) : Quark {
        gluon.setGreen(green)
        return this
    }
    override fun toString() : String {
        return fundamentals.toString()
    }
}