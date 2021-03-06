$(document).ready( function() {
        $("#addOfferToTheSystem").on("click", function (e) {
            e.preventDefault();
            if (validateFields()) {
                var inputTittle = $("#tittle").val();
                var inputPrice = $("#price").val();
                var inputOfferAddress = $("#offerAddress").val();
                var inputImage_preview_addOffer;
                if (document.getElementById('file').files.item(0) === null || document.getElementById('file').files.item(0) === undefined) {
                    inputImage_preview_addOffer = "default.jpeg";
                } else {
                    inputImage_preview_addOffer = document.getElementById('file').files.item(0).name;
                }
                var inputCarBrand = $("#CarBrand").val();
                var inputCarModelVehicle = $("#CarModelVehicle").val();
                var inputCarYearOfManufacture = $("#CarYearOfManufacture").val();
                var inputCarBodyType = $("#CarBodyType").val();
                var inputCarGearBox = $("#CarGearBox").val();
                var inputCarEngineCapacity = $("#CarEngineCapacity").val();
                var inputOfferDescription = $("#offerDescription").val();

                var formData = new FormData();

                var file = document.getElementById('file').files.item(0);
                if (file !== null && file !== undefined && (file.type.match(/image.*/))) {
                    formData.append("file", file);
                }

                formData.append("tittle", inputTittle);
                formData.append("price", inputPrice);
                formData.append("offerAddress", inputOfferAddress);
                formData.append("offerDescription", inputOfferDescription);
                formData.append("image_preview_addOffer", inputImage_preview_addOffer);
                formData.append("carBrand", inputCarBrand);
                formData.append("carModelVehicle", inputCarModelVehicle);
                formData.append("carYearOfManufacture", inputCarYearOfManufacture);
                formData.append("carBodyType", inputCarBodyType);
                formData.append("carGearBox", inputCarGearBox);
                formData.append("carEngineCapacity", inputCarEngineCapacity);

                $.ajax({
                    url: './offer',
                    cache: false,
                    contentType: false,
                    processData: false,
                    method: 'POST',
                    data: formData,
                    error: function (message) {
                        console.log(message);
                    },
                    complete: function (data) {
                        var jsonObj = $.parseJSON(data.responseText);
                        $("#closeAddOfferModalWindow").click();
                        loadOfferInfo(jsonObj);
                    }
                })
            }
        })
    }
);

function validateFields() {
    return checkAddOfferInputFields();
}


