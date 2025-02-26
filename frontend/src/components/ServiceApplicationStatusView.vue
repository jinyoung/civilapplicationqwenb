<template>

    <v-data-table
        :headers="headers"
        :items="serviceApplicationStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ServiceApplicationStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            serviceApplicationStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/serviceApplicationStatuses'))

            temp.data._embedded.serviceApplicationStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.serviceApplicationStatus = temp.data._embedded.serviceApplicationStatuses;
        },
        methods: {
        }
    }
</script>

