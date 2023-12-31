package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.cosmic._physics._subatomic.bosons.IEmitter
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.luminescent.*
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.dictionary.protons.ValueProton
import kotlin.reflect.KClass


open class Quark(
    private val matter: IMatter = Matter(Quark::class, AntiQuark::class),
) : Particle(),
    IMatter by matter,
    IEmitter
{
    constructor() : this(
        Matter(Quark::class, AntiQuark::class),
    ) {
        this.gluon         = Red_AntiRed()
    }
    constructor(baryon: Baryon) : this() {
        this.p_baryon = baryon
    }

    init {
    }

    lateinit var gluon                  : Gluon
    protected lateinit var p_baryon     : Baryon

    companion object {
        fun value(atom: Atom) : Quark {
            val proton = atom.getProton(ValueProton::class)
            return value(proton)
        }
        fun value(atom: Atom, kClass: KClass<*>) : Quark {
            val proton = atom.getProton(kClass)
            return value(proton)
        }
        fun value(proton: Proton) : Quark {
            return proton.getValueQuark()
        }
    }
    open fun i() : Quark {
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);
        this.gluon              = Red_AntiRed()  // this is need for JS Bug

        var remainder : Photon  = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matter.getClassId()
    }
    class Args(val value:Any?) : ZBoson()



    fun blue() : String {
        if (gluon.color.isBlue())
            return gluon.color._value as String

        if (gluon.color.isGreen())
            gluon = Green_AntiRed().blue(gluon)
        else gluon = Red_AntiGreen().blue(gluon)

        return gluon.color._value as String
    }
    fun currentColor() : Any? {
        return gluon.color._value
    }
    open fun dissipate() : Unit {

    }


    fun green() : String {
        if (gluon.color.isGreen())
            return gluon.color._value as String

        if (gluon.color.isBlue())
            gluon = Blue_AntiRed().green(gluon)
        else gluon = Red_AntiBlue().green(gluon)

        return gluon.color._value as String
    }
    fun red() : Any? {
        if (gluon.color.isRed())
            return gluon.color._value

        if (gluon.color.isGreen())
            gluon = Green_AntiBlue().red(gluon)
        else gluon = Blue_AntiGreen().red(gluon)

        return gluon.color._value
    }

    fun setGreen(green: Green) : Quark {
        gluon.setGreen(green)
        return this
    }
    override fun toString() : String {
        return super.toString()
    }
    fun z(boson: Args) : Args {
        red()

        // need a way to transmit errors back
        // should I use a return code or something more
        // elaborate like electrons, neutrinos, etc
        // Args should be Z or W Bosons


        gluon.setValue(boson.value)
        setWavelength(boson.value)

        return boson
    }
    private fun radiate() : String {
        return matter.getClassId()+
                super.emit().radiate()
    }
}