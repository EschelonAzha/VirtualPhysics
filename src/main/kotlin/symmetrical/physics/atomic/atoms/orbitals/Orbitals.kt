package symmetrical.physics.atomic.atoms.orbitals
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

import symmetrical.physics.atomic.atoms.Atom
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.spacial.ParticleBeam
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.leptons.Electron


// For more information visit:  https://en.wikipedia.org/wiki/Atomic_orbital

open class Orbitals(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter().with(Orbitals::class),
) : ParticleBeam(),
    IMatterAntiMatter by matterAntiMatter,
    IOrbitals
{
    private lateinit var p_atom: Atom

    init {
        add(Electron())
    }

    object Static {
        const val VALUE     : Int = ParticleBeam.Static.LAST+1
        const val LAST      : Int = VALUE
    }

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
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    override fun electronSpin() : Boolean {

        return getValueElectron().spin()
    }
    override fun electronValue() : Any? {
        return getValueElectron().wavelength()
    }
    override fun electronValueStr() : String {
        return getValueElectron().wavelengthStr()
    }
    override fun getValueElectron() : Electron {
        if (size() == 0) {
            val electron = Electron()
            electron.setOrbitals(this)
            add(electron)
        }
        return get(Static.VALUE) as Electron
    }
    override fun setAtom(atom: Atom) : Atom {
        //   add(Electron().i(atom))
        this.p_atom = atom
        return atom
    }

    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("Orbitals")
        }
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
}