package symmetrical.cosmic.physics.subatomic.matter.leptons
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

import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic.physics.subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic.physics.subatomic.bosons.Photon
import symmetrical.cosmic.physics.subatomic.spacial.ParticleBeam
import symmetrical.cosmic.physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.Positron
import symmetrical.cosmic.physics.subatomic.balanced.IParticle
import symmetrical.cosmic.physics.subatomic.luminescent.IMatter
import symmetrical.cosmic.physics.subatomic.luminescent.Matter
import symmetrical.cosmic.physics.subatomic.matter.bosons.ZBoson
import symmetrical.cosmic.physics.subatomic.matter.hadrons.baryons.Proton

/*
https://en.wikipedia.org/wiki/Electron
 */
class Electron(
    private val matterAntiMatter: IMatter = Matter(Electron::class),
) : Lepton(),
    IMatter by matterAntiMatter
{
    constructor() : this(
        Matter(Electron::class),
    )
    init {
    }
            lateinit var orbitals       : Orbitals
    private          var particleBeam   : ParticleBeam = ParticleBeam()
    private lateinit var proton         : Proton

    fun i(orbitals:Orbitals) : Electron {
        super.i()
        this.orbitals = orbitals
        return this
    }
    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    fun covalentBond(you: Electron) : Electron {
        you.setElectron(this)
        this.setSpin(Spin.Static.PLUS)
        return this
    }
    fun flow() : ParticleBeam {
        val result : ParticleBeam = ParticleBeam()
        for (i:Int in 0 until particleBeam.size()) {
            val electron = particleBeam.get(i) as Electron
            result.add(flow(electron))
        }

        return result
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }

    fun ionicBond(you: Electron) : Electron {
        you.setElectron(this)
        this.setSpin(Spin.Static.MINUS)
        return this
    }

    fun setOrbitals(orbitals: Orbitals) : Electron {
        this.orbitals = orbitals
        return this
    }

    private fun radiate() : String {
        return matterAntiMatter.getClassId()+
                super.emit().radiate()
    }
    fun setProton(proton: Proton) : Electron {
        this.proton = proton
        return this
    }
    fun setSpin(spin:Int) : Electron {
        getSpin().setSpin(spin)
        return this
    }
    private fun flow(electron: Electron) : ZBoson {
        val terminal: Proton? = electron!!.proton

        if (terminal == null)
            return ZBoson().with(Wavelength.field(proton))
        if (electron.getSpin().isPlus()) {
            return terminal.interact(ZBoson().with(Wavelength.field(proton)))
        } else {
            val field = Wavelength.field(terminal)
            return terminal.capacitanceChange(ZBoson().with(Wavelength.field(proton)).setOldValue(field.getContent()))
        }

    }
    private fun setElectron(electron: Electron) : Electron {
        val particle: IParticle = electron as IParticle
        val pos = particleBeam.find(electron as IParticle)
        if (pos == -1)
            particleBeam.add(electron)

        return this
    }
}