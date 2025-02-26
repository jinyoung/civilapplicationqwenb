<template>

    <v-data-table
        :headers="headers"
        :items="serviceApplicationDetails"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ServiceApplicationDetailsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            serviceApplicationDetails : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/serviceApplicationDetails'))

            temp.data._embedded.serviceApplicationDetails.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.serviceApplicationDetails = temp.data._embedded.serviceApplicationDetails;
        },
        methods: {
        }
    }
</script>

