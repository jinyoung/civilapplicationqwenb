<template>

    <v-card outlined>
        <v-card-title>
            ServiceApplicationId
        </v-card-title>

        <v-card-text>
            <String label="ApplicationId" v-model="value.applicationId" :editMode="editMode"/>
            <Date label="SubmissionDate" v-model="value.submissionDate" :editMode="editMode"/>
            <ApplicationType offline label="ApplicationType" v-model="value.applicationType" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions v-if="inList">
            <slot name="actions"></slot>
        </v-card-actions>
    </v-card>
</template>

<script>

    export default {
        name: 'ServiceApplicationId',
        components:{},
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
            inList: Boolean,
            label: String,
        },
        data: () => ({
        }),
        async created() {
            if(!Object.values(this.value)[0]) {
                this.$emit('input', {});
                this.newValue = {
                    'applicationId': '',
                    'submissionDate': '',
                    'applicationType': '',
                }
            }
            if(typeof this.value === 'object') {
                if(!('applicationId' in this.value)) {
                    this.value.applicationId = '';
                }
            }
            if(typeof this.value === 'object') {
                if(!('submissionDate' in this.value)) {
                    this.value.submissionDate = '2025-02-26';
                }
            }
        },
        watch: {
            value(val) {
                this.$emit('input', val);
            },
            newValue(val) {
                this.$emit('input', val);
            },
        },

        methods: {
            edit() {
                this.editMode = true;
            },
            async add() {
                this.editMode = false;
                this.$emit('input', this.value);

                if(this.isNew){
                    this.$emit('add', this.value);
                } else {
                    this.$emit('edit', this.value);
                }
            },
            async remove(){
                this.editMode = false;
                this.isDeleted = true;

                this.$emit('input', this.value);
                this.$emit('delete', this.value);
            },
            change(){
                this.$emit('change', this.value);
            },
        }
    }
</script>

