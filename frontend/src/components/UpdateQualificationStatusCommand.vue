<template>
    <v-card outlined>
        <v-card-title>
            UpdateQualificationStatus
        </v-card-title>

        <v-card-text>
            <EligibilityStatus offline label="Status" v-model="value.status" :editMode="editMode" @change="change"/>
            <Boolean label="Result" v-model="value.result" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateQualificationStatus"
            >
                UpdateQualificationStatus
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateQualificationStatusCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.status = {};
            this.value.result = false;
        },
        watch: {
        },
        methods: {
            updateQualificationStatus() {
                this.$emit('updateQualificationStatus', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

