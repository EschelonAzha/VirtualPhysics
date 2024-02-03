package symmetrical.physics.subatomic.matter.hadrons.baryons
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

import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.anti_matter.anti_hadrons.anti_baryons.AntiBaryon
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.beta.BetaMinus
import symmetrical.physics.subatomic.matter.beta.BetaPlus
import symmetrical.physics.subatomic.matter.colors.Green
import symmetrical.physics.subatomic.matter.hadrons.Hadron


// For more information visit:   https://en.wikipedia.org/wiki/Baryon

open class Baryon(
    private val matterAntiMatter: IMatter = Matter().with(symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon::class),
) : symmetrical.physics.subatomic.matter.hadrons.Hadron(),
    IMatter by matterAntiMatter
{
    init {
        super.capacity(3)
    }

    object Static {
        const val LAST : Int = symmetrical.physics.subatomic.matter.hadrons.Hadron.Static.LAST
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    // Proton absorbs BetaMinus and becomes Neutron
    fun absorb(beta: symmetrical.physics.subatomic.matter.beta.BetaMinus) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {

        set(1, Down())
        val up: Up = get(0) as Up
        up.z(Quark.Args(beta.getElectron().wavelength()))

        beta.getAntiNeutrino()  // points to proton

        return this
    }
    // Neutron absorbs BetaPlus and becomes Proton
    fun absorb(beta: symmetrical.physics.subatomic.matter.beta.BetaPlus) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {

        set(1, Up())

        var up     = get(0) as Up
        var down = get(2) as Down
        up.z(Quark.Args(beta.getPositron().wavelength()))
        down.z(Quark.Args(beta.getNeutrino().wavelength()))

        return this
    }

    fun betaPlusDecay() : Pair<symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon, symmetrical.physics.subatomic.matter.beta.BetaPlus> {
        var beta        = symmetrical.physics.subatomic.matter.beta.BetaPlus()
        this.set(1, beta.decay(this))
        return Pair(this, beta)
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    fun exchange(baryon: symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {
        return this
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun isNeutron() : Boolean {
        return (this.get(1) as Quark) is Down
    }
    fun isProton() : Boolean {
        return (this.get(1) as Quark) is Up
    }
    fun Neutron() : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {
        this.add(Up().with(this))    // value
        this.add(Down().with(this))  // When down Points to Proton
        this.add(Down().with(this))  // type
        shrink()
        return this
    }
    fun Proton() : Quark {
        val down = this.add(Down().with(this))  // type
        this.add(Up().with(this))    // value
        this.add(Up().with(this))    // When Up Points to Neutron

        shrink()
        return down as Quark
    }


    // Turn this Neutron into a Proton
    fun betaMinusDecay() : Pair<symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon, symmetrical.physics.subatomic.matter.beta.BetaMinus> {
        var beta        = symmetrical.physics.subatomic.matter.beta.BetaMinus()
        this.set(1, beta.decay(this))
        return Pair(this, beta)
    }
    // Turn this Proton into a Neutron

    fun blue() : String {
        return (this.get(0) as Quark).blue()
    }
    fun currentColor() : Any? {
        return (this.get(0) as Quark).currentColor()
    }
    fun green() : String {
        return (this.get(0) as Quark).green()
    }
    fun red() : Any? {
        return (this.get(0) as Quark).red()
    }
    override fun set(pos:Int, quark: symmetrical.physics.subatomic.balanced.IParticle) : symmetrical.physics.subatomic.balanced.IParticle {
        super.set(pos, quark)
        (quark as Quark).setBaryon(this)
        return quark
    }
    fun setBinding(boundTo: symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {
        val up: Quark = this.get(1) as Quark
        (this.get(1) as Quark).z(Quark.Args(boundTo))
        return this
    }
    fun setGreen(green: symmetrical.physics.subatomic.matter.colors.Green) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {
        (get(0) as Quark).setGreen(green)
        return this
    }
    fun setPurpose(value:Any?) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {
        var item = this.get(0)
        var down: Down = this.get(0) as Down
        down.z(Quark.Args(value))
        return this
    }
    public fun setValue(value:Any?) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon {
        var down: Down = this.get(0) as Down
        //  up.setValue(value)
        down.z(Quark.Args(value))
        return this
    }

    private fun radiate() : String {
        if (symmetrical.physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Baryon")
        }
        val classId:String = matterAntiMatter.getClassId()
        val hadron :String = super.emit().radiate()
        return classId+hadron
    }
}