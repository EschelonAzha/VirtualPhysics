package symmetrical.physics.subatomic.matter.quarks
/*
 * This file is part of Virtual Physics.
 *
 * Copyright (C) [2024] Stephen R. DeSofi AKA Eschelon Azha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.bosons.gluons.*
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.dictionary.protons.ValueProton
import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.anti_matter.anti_quarks.AntiQuark
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.bosons.gluons.*
import symmetrical.physics.subatomic.matter.bosons.Gluon
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.colors.Green
import symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon
import symmetrical.physics.subatomic.matter.hadrons.baryons.Proton
import symmetrical.physics.subatomic.bosons.gluons.*
import kotlin.reflect.KClass

// For more information visit:   https://en.wikipedia.org/wiki/Quark
open class Quark(
    private val matterAntiMatter: IMatter = Matter().with(Quark::class),
) : Particle(),
    IMatter by matterAntiMatter,
    IEmitter
{

    lateinit var gluon                  : Gluon
    protected lateinit var p_baryon     : Baryon
    init {
        this.gluon         = Red_AntiRed()
    }
    fun with(baryon: Baryon) : Quark {
        this.p_baryon = baryon
        return this
    }

    companion object {
        fun value(atom: Atom) : Quark {
            val proton = atom.getProton(ValueProton::class)
            return value(proton)
        }
        fun value(atom: Atom, classType: KClass<*>) : Quark {
            val proton = atom.getProton(classType)
            return value(proton)
        }
        fun value(proton: Proton) : Quark {
            return proton.getValueQuark()
        }
    }
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);
        this.gluon              = Red_AntiRed()  // this is need for JS Bug

        var remainder : Photon = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    fun getBaryon() : Baryon {
        return p_baryon
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
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

    fun setBaryon(baryon: Baryon) : Quark {
        this.p_baryon = baryon
        return this
    }
    fun setContent(content:Any?) : Quark {
        getWavelength().setContent(content)
        return this
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
        if (Particle.Static.debuggingOn) {
            println("Quark")
        }

        val classId  : String = matterAntiMatter.getClassId()
        val particle : String = super.emit().radiate()
        return classId+particle
    }
}