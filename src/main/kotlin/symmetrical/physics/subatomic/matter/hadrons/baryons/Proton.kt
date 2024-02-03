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

import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Down
import symmetrical.physics.subatomic.matter.quarks.Up
import symmetrical.physics.subatomic.spacial.ParticleBeam
import symmetrical.physics.atomic.atoms.nucleons.Protons
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle
import symmetrical.physics.subatomic.balanced.IParticle
import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.matter.leptons.Electron


// For more information visit:   https://en.wikipedia.org/wiki/Proton

open class Proton(
    private val matterAntiMatter: IMatter = Matter().with(symmetrical.physics.subatomic.matter.hadrons.baryons.Proton::class),
) : symmetrical.physics.subatomic.matter.hadrons.baryons.Baryon(),
    IMatter by matterAntiMatter
{
    var _quark:Quark
    private var p_protons       : Protons? = null
    private var autoFlow        : Boolean  = true
    private var flowing         : Boolean  = false

    init {
        _quark = this.Proton()
        // +2/3 wavelength(value),                 Spin(isFormatted),          AngularMomentum(Format),
        // +2/3 wavelength(validator),             Spin(isValidationActive),   AngularMomentum(Ptr to Electron),
        // -1/3 wavelength(Type Of Proton),        Spin(?),
    }
    fun with(value:Any?) : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        getValueQuark().setContent(value)
        return this
    }

    enum class QuarkType(val value:Int) {
        VALUE(0),
        CONSTRAINTS(1),
        UP(2),
    }

    object Static {
    }

    override fun absorb(photon: Photon) : Photon {
        matterAntiMatter.check(photon);

        clear()
        var remainder = photon.propagate()

        remainder = super.absorb(remainder)

        _quark    = get(0) as Quark
        return remainder
    }
    fun capacitanceChange(zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        if (p_protons != null)
            p_protons!!.capacitanceChange(this, getValueQuark(), zBoson)

        return zBoson
    }
    fun covalentBond(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton, autoFlow:Boolean = true) : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        proton.autoFlow = autoFlow
        val myElectron  = getElectron()
        val youElectron = proton.getElectron()
        if (myElectron == null)
            return this
        if (youElectron ==  null)
            return this
        myElectron.covalentBond(youElectron)
        return this
    }

    override fun emit() : Photon {
        val classId = matterAntiMatter.getClassId()
        return Photon().with(radiate())
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    fun getConstraintsQuark() : Up {
        return get(symmetrical.physics.subatomic.matter.hadrons.baryons.Proton.QuarkType.CONSTRAINTS.value) as Up
    }

    fun getUpQuark() : Up {
        return get(symmetrical.physics.subatomic.matter.hadrons.baryons.Proton.QuarkType.UP.value) as Up
    }
    fun getValueQuark() : Down {
        return get(symmetrical.physics.subatomic.matter.hadrons.baryons.Proton.QuarkType.VALUE.value) as Down
    }

    fun ionicBond(proton: symmetrical.physics.subatomic.matter.hadrons.baryons.Proton) : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        val myElectron  = getElectron()
        val youElectron = proton.getElectron()
        if (myElectron == null)
            return this
        if (youElectron ==  null)
            return this
        myElectron.ionicBond(youElectron)
        return this
    }
    fun interact(zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        if (flowing)
            return zBoson

        val newValue  : Field                       = zBoson.getNewField()
        val valueQuark: Down                        = getValueQuark()
        val wavelength: QuasiParticle = valueQuark.getWavelength().getQuantumField()
        zBoson.setOldValue(wavelength.getContent())

        if (!noChange(zBoson).isAccepted())
            return zBoson // not accepted, nothing changed

        var accept = valueChange(valueQuark, zBoson)
        if (!zBoson.isAccepted()) {
            return zBoson  // preValueChange rejected change
        }

        if (autoFlow) {
            flowing = true
            val beam: ParticleBeam = flow() // beam has the remote changes.   Not being used yet
            flowing = false
        }

        return zBoson  // this returns only the local changes
    }

    fun setProtons(protons:Protons) : symmetrical.physics.subatomic.matter.hadrons.baryons.Proton {
        this.p_protons = protons
        return this
    }


    private fun flow() : ParticleBeam {
        val electron: symmetrical.physics.subatomic.matter.leptons.Electron = getElectron() ?: return ParticleBeam()
        return electron.flow()
    }
    private fun getElectron() : symmetrical.physics.subatomic.matter.leptons.Electron? {
        val electron : symmetrical.physics.subatomic.matter.leptons.Electron = p_protons?.getElectron(this) ?: return null

        electron.setProton(this)

        return electron
    }


    private fun noChange(zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        val newValue  : Field                   = zBoson.getNewField()
        val valueQuark: Down                    = getValueQuark()
        val wavelength: QuasiParticle = valueQuark.getWavelength().getQuantumField()
        if (!wavelength.isChange(newValue)) {
            zBoson.setAccepted(false)
        }
        zBoson.setAccepted(true)
        return zBoson
    }
    private fun radiate() : String {
        if (symmetrical.physics.subatomic.balanced.Particle.Static.debuggingOn) {
            println("Proton")
        }

        val classId : String = matterAntiMatter.getClassId()
        val baryon  : String = super.emit().radiate()
        return classId+baryon
    }
    private fun valueChange(valueQuark:Down, zBoson: symmetrical.physics.subatomic.matter.bosons.ZBoson) : symmetrical.physics.subatomic.matter.bosons.ZBoson {
        if (p_protons != null)
            p_protons!!.valueChange(this, valueQuark, zBoson)
        return zBoson
    }


}