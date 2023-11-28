package symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.matter.quarks.Quark

open class AntiQuark(
    private val antiMatter: IAntiMatter = AntiMatter(AntiQuark::class),
) : Particle(),
    IAntiMatter by antiMatter,
    Emitter
{
    constructor() : this(
        AntiMatter(Quark::class),
    )

    private var gluon       : Gluon         = Red_AntiRed()
    private var fundamental : Fundamentals  = Fundamentals()



    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        this.gluon                                  = Red_AntiRed()  // this is need for JS Bug
        val (clone, remainder)        = Absorber.materialize(photon.propagate())
        this.fundamental                            = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+fundamental.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    open fun i() : AntiQuark {
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



    fun getValue() : Any? {
        return getWavelength()
    }
    fun getPhoton() : Photon {
        return fundamental.getPhoton()
    }
    fun getMomentum() : AngularMomentum {
        return fundamental.getAngularMomentum()
    }
    fun getSpin() : Spin {
        return fundamental.getSpin()
    }
    fun getWavelength() : Wavelength {
        return fundamental.getWavelength()
    }
    fun setSpin(spin: Spin) : AntiQuark {
        this.fundamental.setSpin(spin)
        return this
    }
    fun setMomentum(momentum: AngularMomentum) : AntiQuark {
        this.fundamental.setMomentum(momentum)
        return this
    }
    fun setValue(value:Any?) : AntiQuark {
        this.setWavelength(value)
        return this
    }
    fun setWavelength(value:Any?) : AntiQuark {
        this.getWavelength().setWavelength(value)
        return this
    }
    fun momentum() : String {
        if (spin())
            return getMomentum().format(getWavelength())
        else return getWavelength().toString()
    }
    fun spin() : Boolean {
        return getSpin().isPlus()
    }
    fun wavelength() : Any? {
        return getWavelength().wavelength()
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

    fun setGreen(green: Green) : AntiQuark {
        gluon.setGreen(green)
        return this
    }
    override fun toString() : String {
        return fundamental.toString()
    }
}