package symmetrical.cosmic._physics._subatomic.balanced.quarks

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Emitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam


open class Quark(private val particle: Particle = Particle()) : IParticle by particle, Emitter {
    object Illuminations {
        public val beam: ParticleBeam = ParticleBeam()
    }
    lateinit var gluon       : Gluon

    private lateinit var fundamentalParticleProperties: Fundamentals


    constructor() : this(Particle()) {
        this.gluon                          = Red_AntiRed()
        this.fundamentalParticleProperties  = Fundamentals()
    }
    public open fun getIlluminations() : ParticleBeam {
        return Illuminations.beam
    }
    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        this.gluon                          = Red_AntiRed()  // this is need for JS Bug
        val (clone, remainder) = Absorber.materialize(photon.propagate())
        this.fundamentalParticleProperties = clone as Fundamentals
        return Photon(remainder)
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+fundamentalParticleProperties.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(Quark::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
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



    fun getValue() : Any? {
        return getWavelength()
    }
    fun getPhoton() : Photon {
        return fundamentalParticleProperties.getPhoton()
    }
    fun getMomentum() : AngularMomentum {
        return fundamentalParticleProperties.getAngularMomentum()
    }
    fun getSpin() : Spin {
        return fundamentalParticleProperties.getSpin()
    }
    fun getWavelength() : Wavelength {
        return fundamentalParticleProperties.getWavelength()
    }
    fun setSpin(spin: Spin) : Quark {
        this.fundamentalParticleProperties.setSpin(spin)
        return this
    }
    fun setMomentum(momentum: AngularMomentum) : Quark {
        this.fundamentalParticleProperties.setMomentum(momentum)
        return this
    }
    fun setValue(value:Any?) : Quark {
        this.setWavelength(value)
        return this
    }
    fun setWavelength(value:Any?) : Quark {
        this.getWavelength().setWavelength(value)
        return this
    }
    fun momentum() : String {
        return getMomentum().format(getWavelength())
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

    fun setGreen(green: Green) : Quark {
        gluon.setGreen(green)
        return this
    }
    override fun toString() : String {
        return fundamentalParticleProperties.toString()
    }
}