package com.movie.service.data;

public class ResponseText {

        private String statusText;

        public ResponseText(String statusText) {
            this.statusText = statusText;
        }

        public ResponseText() {
        }

        public String getStatusText() {
            return statusText;
        }

        public void setStatusText(String statusText) {
            this.statusText = statusText;
        }
}

