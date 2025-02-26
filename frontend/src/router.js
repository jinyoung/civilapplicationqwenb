
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import CitizenServiceApplicationServiceApplicationManager from "./components/listers/CitizenServiceApplicationServiceApplicationCards"
import CitizenServiceApplicationServiceApplicationDetail from "./components/listers/CitizenServiceApplicationServiceApplicationDetail"

import ServiceApplicationStatusView from "./components/ServiceApplicationStatusView"
import ServiceApplicationStatusViewDetail from "./components/ServiceApplicationStatusViewDetail"
import ServiceApplicationDetailsView from "./components/ServiceApplicationDetailsView"
import ServiceApplicationDetailsViewDetail from "./components/ServiceApplicationDetailsViewDetail"
import QualificationVerificationQualificationCheckManager from "./components/listers/QualificationVerificationQualificationCheckCards"
import QualificationVerificationQualificationCheckDetail from "./components/listers/QualificationVerificationQualificationCheckDetail"

import QualificationStatusViewView from "./components/QualificationStatusViewView"
import QualificationStatusViewViewDetail from "./components/QualificationStatusViewViewDetail"
import QualificationHistoryViewView from "./components/QualificationHistoryViewView"
import QualificationHistoryViewViewDetail from "./components/QualificationHistoryViewViewDetail"
import DocumentManagementDocumentManagementManager from "./components/listers/DocumentManagementDocumentManagementCards"
import DocumentManagementDocumentManagementDetail from "./components/listers/DocumentManagementDocumentManagementDetail"

import DocumentStatusViewView from "./components/DocumentStatusViewView"
import DocumentStatusViewViewDetail from "./components/DocumentStatusViewViewDetail"
import DocumentHistoryViewView from "./components/DocumentHistoryViewView"
import DocumentHistoryViewViewDetail from "./components/DocumentHistoryViewViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/citizenServiceApplications/serviceApplications',
                name: 'CitizenServiceApplicationServiceApplicationManager',
                component: CitizenServiceApplicationServiceApplicationManager
            },
            {
                path: '/citizenServiceApplications/serviceApplications/:id',
                name: 'CitizenServiceApplicationServiceApplicationDetail',
                component: CitizenServiceApplicationServiceApplicationDetail
            },

            {
                path: '/citizenServiceApplications/serviceApplicationStatuses',
                name: 'ServiceApplicationStatusView',
                component: ServiceApplicationStatusView
            },
            {
                path: '/citizenServiceApplications/serviceApplicationStatuses/:id',
                name: 'ServiceApplicationStatusViewDetail',
                component: ServiceApplicationStatusViewDetail
            },
            {
                path: '/citizenServiceApplications/serviceApplicationDetails',
                name: 'ServiceApplicationDetailsView',
                component: ServiceApplicationDetailsView
            },
            {
                path: '/citizenServiceApplications/serviceApplicationDetails/:id',
                name: 'ServiceApplicationDetailsViewDetail',
                component: ServiceApplicationDetailsViewDetail
            },
            {
                path: '/qualificationVerifications/qualificationChecks',
                name: 'QualificationVerificationQualificationCheckManager',
                component: QualificationVerificationQualificationCheckManager
            },
            {
                path: '/qualificationVerifications/qualificationChecks/:id',
                name: 'QualificationVerificationQualificationCheckDetail',
                component: QualificationVerificationQualificationCheckDetail
            },

            {
                path: '/qualificationVerifications/qualificationStatusViews',
                name: 'QualificationStatusViewView',
                component: QualificationStatusViewView
            },
            {
                path: '/qualificationVerifications/qualificationStatusViews/:id',
                name: 'QualificationStatusViewViewDetail',
                component: QualificationStatusViewViewDetail
            },
            {
                path: '/qualificationVerifications/qualificationHistoryViews',
                name: 'QualificationHistoryViewView',
                component: QualificationHistoryViewView
            },
            {
                path: '/qualificationVerifications/qualificationHistoryViews/:id',
                name: 'QualificationHistoryViewViewDetail',
                component: QualificationHistoryViewViewDetail
            },
            {
                path: '/documentManagements/documentManagements',
                name: 'DocumentManagementDocumentManagementManager',
                component: DocumentManagementDocumentManagementManager
            },
            {
                path: '/documentManagements/documentManagements/:id',
                name: 'DocumentManagementDocumentManagementDetail',
                component: DocumentManagementDocumentManagementDetail
            },

            {
                path: '/documentManagements/documentStatusViews',
                name: 'DocumentStatusViewView',
                component: DocumentStatusViewView
            },
            {
                path: '/documentManagements/documentStatusViews/:id',
                name: 'DocumentStatusViewViewDetail',
                component: DocumentStatusViewViewDetail
            },
            {
                path: '/documentManagements/documentHistoryViews',
                name: 'DocumentHistoryViewView',
                component: DocumentHistoryViewView
            },
            {
                path: '/documentManagements/documentHistoryViews/:id',
                name: 'DocumentHistoryViewViewDetail',
                component: DocumentHistoryViewViewDetail
            },


    ]
})
