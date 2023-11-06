package symmetrical.cosmic.__recycle

import symmetrical.cosmic._physics._subatomic.bosons.Gluon
import asymmetrical.machine.config.Config
import asymmetrical.machine.dom.peers.HtmlPeer
import asymmetrical.machine.vm.Classes
import symmetrical.cosmic.__transpectors.transpectors.Strings
import symmetrical.cosmic._bitmaps.*
import symmetrical.cosmic._physics._subatomic.forces.strong_force.*
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiBlue
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiGreen
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiRed
import symmetrical.cosmic._physics._subatomic.matter.colors.Blue
import symmetrical.cosmic._physics._subatomic.matter.colors.Green
import symmetrical.cosmic._physics._subatomic.matter.colors.Red
import symmetrical.cosmic._physics._subatomic.matter.colors.manifestations.CRLFTerminatedColor
import symmetrical.cosmic._physics._subatomic.forces.weak_force.ChargedWeak
import symmetrical.cosmic._physics._subatomic.matter.bosons.WBoson
import symmetrical.cosmic._physics._subatomic.forces.weak_force.neutral.ChargedWeakForce
import symmetrical.cosmic._physics._subatomic.matter.bosons.ZBoson
import symmetrical.cosmic._physics._subatomic.spatial.Beam
import symmetrical.cosmic._physics._subatomic.spatial.Composition
import symmetrical.cosmic._physics._subatomic.spatial.ParticleBeam
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaMinus
import symmetrical.cosmic._physics._subatomic.matter.beta.BetaPlus
import symmetrical.cosmic._physics._subatomic.balanced.pairs.ElectronPositron
import symmetrical.cosmic._physics._subatomic.balanced.pairs.LeptonPair
import symmetrical.cosmic._physics._subatomic.matter.hadrons.Hadron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Baryon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Neutron
import symmetrical.cosmic._physics._subatomic.matter.hadrons.baryons.Proton
import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic._physics.atomic.atoms.elements.Helium
import symmetrical.cosmic._physics.atomic.atoms.elements.Hydrogen
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Nucleons
import symmetrical.cosmic._physics.atomic.atoms.states.booleans.QBoolean
import symmetrical.cosmic._physics.atomic.atoms.states.bytes.QByte
import symmetrical.cosmic._physics.atomic.atoms.states.doubles.QDouble
import symmetrical.cosmic._physics.atomic.atoms.states.integers.QInt
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic._physics.atomic.atoms.states.vectors.QMass
import symmetrical.cosmic._physics.atomic.blackhole.Blackhole
import symmetrical.cosmic._physics.atomic.blackhole.EventHorizon
import symmetrical.cosmic._physics.atomic.bonds.alloys.Alloy
import symmetrical.cosmic._physics.atomic.matter.Matter
import symmetrical.cosmic._physics.atomic.substance.ions.Anion
import symmetrical.cosmic._physics.atomic.substance.ions.Cation
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic._physics.atomic.substance.ions.Ion
import symmetrical.cosmic._physics.atomic.substance.metals.Metal
import symmetrical.cosmic._physics.atomic.substance.molecules.Molecule
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.CRLFTerminatedSpin
import symmetrical.cosmic._physics._subatomic.balanced.color.ColorCharges
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Neutrons
import symmetrical.cosmic._physics.atomic.atoms.nucleons.Protons
import symmetrical.cosmic._physics.atomic.atoms.orbitals.Orbitals
import symmetrical.cosmic._physics._subatomic.balanced.quarks.QuarkValue
import symmetrical.cosmic._physics.atomic.atoms.states.strings.phases.CrLfTerminatedString
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Mixture
import symmetrical.cosmic._physics.atomic.bonds.mixtures.Solution
import symmetrical.cosmic._physics.atomic.matter.Material
import symmetrical.cosmic.__transpectors.printable_characters.*
import symmetrical.cosmic._physics._creation.BigBang
import symmetrical.cosmic._physics._creation.Universe
import symmetrical.cosmic._physics._dimensions.time.Strobe
import symmetrical.cosmic._physics._dimensions.time.Time
import symmetrical.cosmic._physics._subatomic.balanced.Monad
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.bosons.Graviton
import symmetrical.cosmic._physics._subatomic.forces.gravity.Gravity
import symmetrical.cosmic._physics._subatomic.balanced.HiggsField
import symmetrical.cosmic._physics._subatomic.forces.magnetism.Magnetism
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_colors.AntiColor
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.*
import symmetrical.cosmic._physics._subatomic.anti_matter.anti_quarks.*
import symmetrical.cosmic._physics._subatomic.bosons.*
import symmetrical.cosmic._physics._subatomic.bosons.gluons.*
import symmetrical.cosmic._physics._subatomic.forces.weak_force.Charge
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.Kaon
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.MinusPion
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralDownPion
import symmetrical.cosmic._physics._subatomic.matter.hadrons.mesons.NeutralUpPion
import symmetrical.cosmic._physics._subatomic.matter.leptons.*
import symmetrical.cosmic._physics._subatomic.matter.quarks.*
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.Fundamentals
import symmetrical.cosmic._physics._subatomic.balanced.color.ChromoCharge
import symmetrical.cosmic._physics._subatomic.matter.colors.Color
import symmetrical.cosmic._physics._subatomic.balanced.color.QCD
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.AngularMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.angularMomentum.CRLFTerminatedMomentum
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.spin.Spin
import symmetrical.cosmic._physics._subatomic.balanced.fundamentals.wavelength.Wavelength
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.balanced.quarks.Quark
import symmetrical.cosmic._physics.atomic.bonds.covalent.Diatomic
import symmetrical.cosmic._physics.atomic.bonds.covalent.Molecular
import symmetrical.cosmic.dictionary.PasswordFld
import symmetrical.cosmic.dictionary.UseridFld
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.wormholes.messaging.login.AppendMSG
import symmetrical.cosmic.wormholes.messaging.login.LoginMSG
import symmetrical.cosmic.wormholes.messaging.login.ReadyMSG
import symmetrical.device.DeviceInput
import symmetrical.cosmic.wormholes.pulsar.dictionary.Host
import symmetrical.cosmic.wormholes.pulsar.dictionary.Path
import symmetrical.cosmic.wormholes.pulsar.socket.Outlet
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage
import symmetrical.dom.Dom
import symmetrical.dom.DomProperties
import symmetrical.dom.DomProperty
import symmetrical.dom.dom.Body
import symmetrical.dom.properties.colors.BackgroundColor
import symmetrical.dom.properties.identification.DomId
import symmetrical.dom.properties.region.DomHeight
import symmetrical.dom.properties.region.DomLeft
import symmetrical.dom.properties.region.DomTop
import symmetrical.dom.properties.region.DomWidth
import symmetrical.dom.properties.style.DomStyle
import kotlin.reflect.KClass

object Absorber {
    val beam: Beam = Beam(500)
    init {
        beam.add(EntityId(Base52.classId(), Alloy::class))
        beam.add(EntityId(Base52.classId(), AngularMomentum::class))
        beam.add(EntityId(Base52.classId(), Anion::class))
        beam.add(EntityId(Base52.classId(), AntiColor::class))
        beam.add(EntityId(Base52.classId(), AntiBlue::class))
        beam.add(EntityId(Base52.classId(), AntiBottom::class))
        beam.add(EntityId(Base52.classId(), AntiCharm::class))
        beam.add(EntityId(Base52.classId(), AntiDown::class))
        beam.add(EntityId(Base52.classId(), AntiGreen::class))
        beam.add(EntityId(Base52.classId(), AntiLepton::class))
        beam.add(EntityId(Base52.classId(), AntiMuon::class))
        beam.add(EntityId(Base52.classId(), AntiMuonNeutrino::class))
        beam.add(EntityId(Base52.classId(), AntiNeutrino::class))
        beam.add(EntityId(Base52.classId(), AntiRed::class))
        beam.add(EntityId(Base52.classId(), AntiStrange::class))
        beam.add(EntityId(Base52.classId(), AntiTau::class))
        beam.add(EntityId(Base52.classId(), AntiTauNeutrino::class))
        beam.add(EntityId(Base52.classId(), AntiTop::class))
        beam.add(EntityId(Base52.classId(), AntiUp::class))
        beam.add(EntityId(Base52.classId(), Atom::class))
        beam.add(EntityId(Base52.classId(), Baryon::class))
        beam.add(EntityId(Base52.classId(), Base52::class))
        beam.add(EntityId(Base52.classId(), Beam::class))
        beam.add(EntityId(Base52.classId(), BetaMinus::class))
        beam.add(EntityId(Base52.classId(), BetaPlus::class))
        beam.add(EntityId(Base52.classId(), BigBang::class))
        beam.add(EntityId(Base52.classId(), Bits04::class))
        beam.add(EntityId(Base52.classId(), Bits08::class))
        beam.add(EntityId(Base52.classId(), Bits16::class))
        beam.add(EntityId(Base52.classId(), Bits24::class))
        beam.add(EntityId(Base52.classId(), Bits32::class))
        beam.add(EntityId(Base52.classId(), Bits64::class))
        beam.add(EntityId(Base52.classId(), Blackhole::class))
        beam.add(EntityId(Base52.classId(), Blue::class))
        beam.add(EntityId(Base52.classId(), Blue_AntiBlue::class))
        beam.add(EntityId(Base52.classId(), Blue_AntiGreen::class))
        beam.add(EntityId(Base52.classId(), Blue_AntiRed::class))
        beam.add(EntityId(Base52.classId(), Bottom::class))
        beam.add(EntityId(Base52.classId(), Cation::class))
        beam.add(EntityId(Base52.classId(), Characters::class))
        beam.add(EntityId(Base52.classId(), Charge::class))
        beam.add(EntityId(Base52.classId(), ChargedWeak::class))
        beam.add(EntityId(Base52.classId(), ChargedWeakForce::class))
        beam.add(EntityId(Base52.classId(), Charm::class))
        beam.add(EntityId(Base52.classId(), ChromoCharge::class))
        beam.add(EntityId(Base52.classId(), Color::class))
        beam.add(EntityId(Base52.classId(), ColorCharges::class))
        beam.add(EntityId(Base52.classId(), Composition::class))
        beam.add(EntityId(Base52.classId(), Compound::class))
        beam.add(EntityId(Base52.classId(), CRLFTerminatedColor::class))
        beam.add(EntityId(Base52.classId(), CRLFTerminatedMomentum::class))
        beam.add(EntityId(Base52.classId(), CRLFTerminatedSpin::class))
        beam.add(EntityId(Base52.classId(), CrLfTerminatedString::class))
        beam.add(EntityId(Base52.classId(), DeviceInput::class))
        beam.add(EntityId(Base52.classId(), Diatomic::class))
        beam.add(EntityId(Base52.classId(), Down::class))
        beam.add(EntityId(Base52.classId(), Electron::class))
        beam.add(EntityId(Base52.classId(), ElectronPositron::class))
        beam.add(EntityId(Base52.classId(), EventHorizon::class))
        beam.add(EntityId(Base52.classId(), Fundamentals::class))
        beam.add(EntityId(Base52.classId(), Gluon::class))
        beam.add(EntityId(Base52.classId(), Graviton::class))
        beam.add(EntityId(Base52.classId(), Gravity::class))
        beam.add(EntityId(Base52.classId(), Green::class))
        beam.add(EntityId(Base52.classId(), Green_AntiBlue::class))
        beam.add(EntityId(Base52.classId(), Green_AntiGreen::class))
        beam.add(EntityId(Base52.classId(), Green_AntiRed::class))
        beam.add(EntityId(Base52.classId(), Hadron::class))
        beam.add(EntityId(Base52.classId(), Helium::class))
        beam.add(EntityId(Base52.classId(), Host::class))
        beam.add(EntityId(Base52.classId(), Hydrogen::class))
        beam.add(EntityId(Base52.classId(), HiggsField::class))
        beam.add(EntityId(Base52.classId(), Higgs::class))
        beam.add(EntityId(Base52.classId(), Ion::class))
        beam.add(EntityId(Base52.classId(), Kaon::class))
        beam.add(EntityId(Base52.classId(), KeyValue::class))
        beam.add(EntityId(Base52.classId(), Lepton::class))
        beam.add(EntityId(Base52.classId(), LeptonPair::class))
        beam.add(EntityId(Base52.classId(), LowerCase::class))
        beam.add(EntityId(Base52.classId(), Magnetism::class))
        beam.add(EntityId(Base52.classId(), Material::class))
        beam.add(EntityId(Base52.classId(), Matter::class))
        beam.add(EntityId(Base52.classId(), Message::class))
        beam.add(EntityId(Base52.classId(), Metal::class))
        beam.add(EntityId(Base52.classId(), MinusPion::class))
        beam.add(EntityId(Base52.classId(), Mixture::class))
        beam.add(EntityId(Base52.classId(), Molecular::class))
        beam.add(EntityId(Base52.classId(), Molecule::class))
        beam.add(EntityId(Base52.classId(), Monad::class))
        beam.add(EntityId(Base52.classId(), Muon::class))
        beam.add(EntityId(Base52.classId(), MuonNeutrino::class))
        beam.add(EntityId(Base52.classId(), Neutrino::class))
        beam.add(EntityId(Base52.classId(), Neutron::class))
        beam.add(EntityId(Base52.classId(), Neutrons::class))
        beam.add(EntityId(Base52.classId(), NeutralDownPion::class))
        beam.add(EntityId(Base52.classId(), NeutralUpPion::class))
        beam.add(EntityId(Base52.classId(), Nucleons::class))
        beam.add(EntityId(Base52.classId(), Numbers::class))
        beam.add(EntityId(Base52.classId(), Orbitals::class))
        beam.add(EntityId(Base52.classId(), Outlet::class))
        beam.add(EntityId(Base52.classId(), Particle::class))
        beam.add(EntityId(Base52.classId(), ParticleBeam::class))
        beam.add(EntityId(Base52.classId(), PasswordFld::class))
        beam.add(EntityId(Base52.classId(), Path::class))
        beam.add(EntityId(Base52.classId(), Photon::class))
        beam.add(EntityId(Base52.classId(), Proton::class))
        beam.add(EntityId(Base52.classId(), Protons::class))
        beam.add(EntityId(Base52.classId(), QuarkValue::class))
        beam.add(EntityId(Base52.classId(), QBoolean::class))
        beam.add(EntityId(Base52.classId(), QByte::class))
        beam.add(EntityId(Base52.classId(), QCD::class))
        beam.add(EntityId(Base52.classId(), QDouble::class))
        beam.add(EntityId(Base52.classId(), QInt::class))
        beam.add(EntityId(Base52.classId(), QString::class))
        beam.add(EntityId(Base52.classId(), QMass::class))
        beam.add(EntityId(Base52.classId(), Quark::class))
        beam.add(EntityId(Base52.classId(), Red::class))
        beam.add(EntityId(Base52.classId(), Red_AntiBlue::class))
        beam.add(EntityId(Base52.classId(), Red_AntiBlue::class))
        beam.add(EntityId(Base52.classId(), Red_AntiRed::class))
        beam.add(EntityId(Base52.classId(), SocketMessage::class))
        beam.add(EntityId(Base52.classId(), Solution::class))
        beam.add(EntityId(Base52.classId(), Spin::class))
        beam.add(EntityId(Base52.classId(), Strange::class))
        beam.add(EntityId(Base52.classId(), Strobe::class))
        beam.add(EntityId(Base52.classId(), Strong::class))
        beam.add(EntityId(Base52.classId(), Tau::class))
        beam.add(EntityId(Base52.classId(), TauNeutrino::class))
        beam.add(EntityId(Base52.classId(), Time::class))
        beam.add(EntityId(Base52.classId(), Top::class))
        beam.add(EntityId(Base52.classId(), Universe::class))
        beam.add(EntityId(Base52.classId(), Up::class))
        beam.add(EntityId(Base52.classId(), UpperCase::class))
        beam.add(EntityId(Base52.classId(), UseridFld::class))
        beam.add(EntityId(Base52.classId(), Wavelength::class))
        beam.add(EntityId(Base52.classId(), WBoson::class))
        beam.add(EntityId(Base52.classId(), ZBoson::class))
        /************************/
        beam.add(EntityId(Base52.classId(), AppendMSG::class))
        beam.add(EntityId(Base52.classId(), BackgroundColor::class))
        beam.add(EntityId(Base52.classId(), Body::class))
        beam.add(EntityId(Base52.classId(), Dom::class))
        beam.add(EntityId(Base52.classId(), DomHeight::class))
        beam.add(EntityId(Base52.classId(), DomId::class))
        beam.add(EntityId(Base52.classId(), DomLeft::class))
        beam.add(EntityId(Base52.classId(), DomStyle::class))
        beam.add(EntityId(Base52.classId(), DomTop::class))
        beam.add(EntityId(Base52.classId(), DomWidth::class))
        beam.add(EntityId(Base52.classId(), DomProperties::class))
        beam.add(EntityId(Base52.classId(), DomProperty::class))
        beam.add(EntityId(Base52.classId(), HtmlPeer::class))
        beam.add(EntityId(Base52.classId(), LoginMSG::class))
        beam.add(EntityId(Base52.classId(), ReadyMSG::class))
    }
    fun initialize() : Absorber {
        return this
    }
    fun newInstance(kClass:KClass<*>) : Any? {
        val result = when {
            kClass == Alloy::class                  -> Alloy()
            kClass == AngularMomentum::class        -> AngularMomentum()
            kClass == Anion::class                  -> Anion()
            kClass == AntiColor::class              -> AntiColor()
            kClass == AntiBlue::class               -> AntiBlue()
            kClass == AntiBottom::class             -> AntiBottom()
            kClass == AntiCharm::class              -> AntiCharm()
            kClass == AntiDown::class               -> AntiDown()
            kClass == AntiGreen::class              -> AntiGreen()
            kClass == AntiLepton::class             -> AntiLepton()
            kClass == AntiMuon::class               -> AntiMuon()
            kClass == AntiMuonNeutrino::class       -> AntiMuonNeutrino()
            kClass == AntiNeutrino::class           -> AntiNeutrino()
            kClass == AntiRed::class                -> AntiRed()
            kClass == AntiStrange::class            -> AntiStrange()
            kClass == AntiTau::class                -> AntiTau()
            kClass == AntiTauNeutrino::class        -> AntiTauNeutrino()
            kClass == AntiTop::class                -> AntiTop()
            kClass == AntiUp::class                 -> AntiUp()
            kClass == Atom::class                   -> Atom()
            kClass == Baryon::class                 -> Baryon()
            kClass == Base52::class                 -> Base52()
            kClass == Beam::class                   -> Beam(0)
            kClass == BetaMinus::class              -> BetaMinus()
            kClass == BetaPlus::class               -> BetaPlus()
            kClass == BigBang::class                -> BigBang()
            kClass == Bits04::class                 -> Bits04()
            kClass == Bits08::class                 -> Bits08()
            kClass == Bits16::class                 -> Bits16()
            kClass == Bits24::class                 -> Bits24()
            kClass == Bits32::class                 -> Bits32()
            kClass == Bits64::class                 -> Bits64()
            kClass == Blackhole::class              -> Blackhole()
            kClass == Blue::class                   -> Blue()
            kClass == Blue_AntiBlue::class          -> Blue_AntiBlue()
            kClass == Blue_AntiGreen::class         -> Blue_AntiGreen()
            kClass == Blue_AntiRed::class           -> Blue_AntiRed()
            kClass == Bottom::class                 -> Bottom()
            kClass == Cation::class                 -> Cation()
            kClass == Characters::class             -> Characters()
            kClass == Charge::class                 -> Charge()
            kClass == ChargedWeak::class            -> ChargedWeak()
            kClass == ChargedWeakForce::class       -> ChargedWeakForce()
            kClass == Charm::class                  -> Charm()
            kClass == ChromoCharge::class           -> ChromoCharge()
            kClass == Color::class                  -> Color()
            kClass == ColorCharges::class           -> ColorCharges()
            kClass == Composition::class            -> Composition()
            kClass == Compound::class               -> Compound()
            kClass == CRLFTerminatedColor::class    -> CRLFTerminatedColor()
            kClass == CRLFTerminatedMomentum::class -> CRLFTerminatedMomentum()
            kClass == CRLFTerminatedSpin::class     -> CRLFTerminatedSpin()
            kClass == CrLfTerminatedString::class   -> CrLfTerminatedString()
            kClass == DeviceInput::class            -> DeviceInput()
            kClass == Diatomic::class               -> Diatomic()
            kClass == Down::class                   -> Down()
            kClass == Electron::class               -> Electron()
            kClass == ElectronPositron::class       -> ElectronPositron()
            kClass == EventHorizon::class           -> EventHorizon()
            kClass == Fundamentals::class           -> Fundamentals()
            kClass == Gluon::class                  -> Gluon()
            kClass == Graviton::class               -> Graviton()
            kClass == Gravity::class                -> Gravity()
            kClass == Green::class                  -> Green()
            kClass == Green_AntiBlue::class         -> Green_AntiBlue()
            kClass == Green_AntiGreen::class        -> Green_AntiGreen()
            kClass == Green_AntiRed::class          -> Green_AntiRed()
            kClass == Hadron::class                 -> Hadron()
            kClass == Helium::class                 -> Helium()
            kClass == Host::class                   -> Host()
            kClass == Hydrogen::class               -> Hydrogen()
            kClass == HiggsField::class             -> HiggsField()
            kClass == Higgs::class                  -> Higgs()
            kClass == Ion::class                    -> Ion()
            kClass == Kaon::class                   -> Kaon()
            kClass == KeyValue::class               -> KeyValue()
            kClass == Lepton::class                 -> Lepton()
            kClass == LeptonPair::class             -> LeptonPair()
            kClass == LowerCase::class              -> LowerCase()
            kClass == Magnetism::class              -> Magnetism()
            kClass == Material::class               -> Material()
            kClass == Matter::class                 -> Matter()
            kClass == Message::class                -> Message()
            kClass == Metal::class                  -> Metal()
            kClass == MinusPion::class              -> MinusPion()
            kClass == Mixture::class                -> Mixture()
            kClass == Molecular::class              -> Molecular()
            kClass == Molecule::class               -> Molecule()
            kClass == Monad::class                  -> Monad()
            kClass == Muon::class                   -> Muon()
            kClass == MuonNeutrino::class           -> MuonNeutrino()
            kClass == Neutrino::class               -> Neutrino()
            kClass == Neutron::class                -> Neutron()
            kClass == Neutrons::class               -> Neutrons()
            kClass == NeutralDownPion::class        -> NeutralDownPion()
            kClass == NeutralUpPion::class          -> NeutralUpPion()
            kClass == Nucleons::class               -> Nucleons()
            kClass == Numbers::class                -> Numbers()
            kClass == Orbitals::class               -> Orbitals()
            kClass == Outlet::class                 -> Outlet()
            kClass == Particle::class               -> Particle()
            kClass == ParticleBeam::class           -> ParticleBeam()
            kClass == PasswordFld::class            -> PasswordFld()
            kClass == Path::class                   -> Path()
            kClass == Photon::class                 -> Photon()
            kClass == Proton::class                 -> Proton()
            kClass == Protons::class                -> Protons()
            kClass == QuarkValue::class             -> QuarkValue()
            kClass == QBoolean::class               -> QBoolean()
            kClass == QByte::class                  -> QByte()
            kClass == QCD::class                    -> QCD()
            kClass == QDouble::class                -> QDouble()
            kClass == QInt::class                   -> QInt()
            kClass == QString::class                -> QString()
            kClass == QMass::class                  -> QMass()
            kClass == Quark::class                  -> Quark()
            kClass == Red::class                    -> Red()
            kClass == Red_AntiBlue::class           -> Red_AntiBlue()
            kClass == Red_AntiBlue::class           -> Red_AntiBlue()
            kClass == Red_AntiRed::class            -> Red_AntiRed()
            kClass == SocketMessage::class          -> SocketMessage()
            kClass == Solution::class               -> Solution()
            kClass == Spin::class                   -> Spin()
            kClass == Strange::class                -> Strange()
            kClass == Strobe::class                 -> Strobe()
            kClass == Strong::class                 -> Strong()
            kClass == Tau::class                    -> Tau()
            kClass == TauNeutrino::class            -> TauNeutrino()
            kClass == Time::class                   -> Time()
            kClass == Top::class                    -> Top()
            kClass == Universe::class               -> Universe()
            kClass == Up::class                     -> Up()
            kClass == UpperCase::class              -> UpperCase()
            kClass == UseridFld::class              -> UseridFld()
            kClass == Wavelength::class             -> Wavelength()
            kClass == WBoson::class                 -> WBoson()
            kClass == ZBoson::class                 -> ZBoson()
            /*****************/
            kClass == AppendMSG::class              -> AppendMSG()
            kClass == BackgroundColor::class        -> BackgroundColor()
            kClass == Body::class                   -> Body()
            kClass == Dom::class                    -> Dom()
            kClass == DomHeight::class              -> DomHeight()
            kClass == DomId::class                  -> DomId()
            kClass == DomLeft::class                -> DomLeft()
            kClass == DomProperties::class          -> DomProperties()
            kClass == DomProperty::class            -> DomProperty()
            kClass == DomStyle::class               -> DomStyle()
            kClass == DomTop::class                 -> DomTop()
            kClass == DomWidth::class               -> DomWidth()
            kClass == HtmlPeer::class               -> HtmlPeer()
            kClass == LoginMSG::class               -> LoginMSG()
            kClass == ReadyMSG::class               -> ReadyMSG()
            else                                    -> null
        }
        return result
    }
    fun createInstance(id:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.id == id) {
                return newInstance(entityId.kClass)
            }
        }
        return null
    }

    fun materialize(photon: Photon) : Pair<Emitter, String> {
        return materialize(photon.radiate())
    }

    fun materialize(emission:String) : Pair<Emitter, String> {
        var (classId, remainder) = Strings.remainder(Config.getClassIdLth(), emission)
        val clone = createInstance(classId) as Emitter
        val remainderPhoton: Photon = clone.absorb(Photon(emission))
        return Pair<Emitter, String>(clone, remainderPhoton.radiate())
    }
    fun getClassId(kClass: KClass<*>) : String {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.kClass == kClass)
                return entityId.id
        }
        println("")
        println("!!!!!!!!!!!!!!!!!!!")
        println("PhotonDetector::getClassId(kClass:KClass could not find: $kClass")
        println("!!!!!!!!!!!!!!!!!!!")
        println("")
        return ""
    }

    fun createInstancex(id:String) : Any? {
        for (i in 0 until beam.size()) {
            val entityId = beam.get(i) as EntityId
            if (entityId.id == id) {
                return Classes.createInstance(entityId.kClass)
            }
        }
        return null
    }

}

