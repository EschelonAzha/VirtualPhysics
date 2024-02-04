package symmetrical.physics.subatomic.anti_matter.anti_quarks
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

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.bosons.IEmitter
import symmetrical.physics.subatomic.matter.bosons.Gluon
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.bosons.gluons.*
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.luminescent.IAntiMatter
import symmetrical.physics.subatomic.luminescent.AntiMatter
import symmetrical.physics.subatomic.matter.colors.Green
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.bosons.gluons.*

// For more information visit:   https://en.wikipedia.org/wiki/Quark
open class AntiQuark(
    private val matterAntiMatter: IAntiMatter = AntiMatter().with(Quark::class),
) : Particle(),
    IAntiMatter by matterAntiMatter,
    IEmitter
{

    private var gluon       : Gluon = Red_AntiRed()

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);
        this.gluon                                 = Red_AntiRed()  // this is need for JS Bug

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }

    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }


    class Args(val value:Any?) : ZBoson()
    fun z(boson: AntiQuark.Args) : AntiQuark.Args {
        red()

        // need a way to transmit errors back
        // should I use a return code or something more
        // elaborate like electrons, neutrinos, etc
        // Args should be Z or W Bosons


        gluon.setValue(boson.value)
        setWavelength(boson.value)

        return boson
    }




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


    fun setGreen(green: Green) : AntiQuark {
        gluon.setGreen(green)
        return this
    }
    override fun toString() : String {
        return super.toString()
    }
}