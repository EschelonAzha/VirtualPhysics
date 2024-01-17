package symmetrical.cosmic.physics.atomic.atoms.orbitals
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

import symmetrical.cosmic.physics.atomic.atoms.Atom
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.matter.quarks.Quark
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.leptons.Electron

/*
https://en.wikipedia.org/wiki/Atomic_orbital
 */
open class Orbitals(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(Orbitals::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    IOrbitals
{
    constructor() : this(
        MatterAntiMatter(Orbitals::class),
    ) init {
        add(Electron())
    }

    object Static {
        const val VALUE     : Int = ParticleBeam.Static.LAST+1
        const val LAST      : Int = VALUE
    }
    private lateinit var p_atom: Atom


    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)

        for (i in 0 until size()) {
            (get(i) as Electron).setOrbitals(this)
        }
        return remainder
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getElectronValue() : Electron {
        if (size() == 0) {
            val electron = Electron()
            electron.setOrbitals(this)
            add(electron)
        }
        return get(Static.VALUE) as Electron
    }
    override fun electronSpin() : Boolean {

        return getElectronValue().spin()
    }
    override fun electronValue() : Any? {
        return getElectronValue().wavelength()
    }
    override fun electronValueStr() : String {
        return getElectronValue().wavelengthStr()
    }
    override fun getElectronPhoton() : Photon {
        return getElectronValue().getPhoton()
    }
    override fun getElectronSpin() : Spin {
        return getElectronValue().getSpin()
    }
    override fun getElectronWavelength() : Any? {
        return getElectronValue().getWavelength()
    }
    override fun setAtom(atom: Atom) : Atom {
        //   add(Electron().i(atom))
        this.p_atom = atom
        return atom
    }

    override fun setElectronSpin(spin: Spin) : Atom {
        getElectronValue().setSpin(spin)
        return p_atom
    }
    override fun setElectronValue(value:Any?) : ZBoson {
        val zBoson = Quark.Args(value)
        getElectronValue().setWavelength(value)
        return zBoson
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Orbitals")
        }
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}